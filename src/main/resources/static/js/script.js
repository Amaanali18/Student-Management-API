const base_url = "http://localhost:8080/api";

// document.addEventListener("DOMContentLoaded",async function checkbackend() {
//     try{
//         const response = await fetch(base_url);
//         if(!response.ok){
//             window.location.href="/src/main/resources/static/html/nobackend.html"
//         }
//         console.log(response)
//     }catch(error){
//         window.location.href="/src/main/resources/static/html/nobackend.html"
//         console.log(error);
//     }
// });

async function loadStudents() {
    await fetch(base_url + "/all")
    .then(response => response.json())
    .then(data => {
        console.log(data);
        const tableBody = document.querySelector("table tbody");
        tableBody.innerHTML = "";
        data.forEach(student => {
            const row = `<tr>
                            <td>${student.enrollmentNumber}</td>
                            <td>${student.name}</td>
                            <td>${student.email}</td>
                            <td>${student.department}</td>
                            <td>${student.contactNumber}</td>
                            <td><a onclick="loadStudent(${student.enrollmentNumber})">Edit</a></td>
                            <td><a onclick="deleteStudent(${student.enrollmentNumber})">Delete</a></td>
                        </tr>`;
            tableBody.innerHTML += row;
        });
    });
}

async function insertStudent(e){
    e.preventDefault();
    const Student = {
        name:document.getElementById("name").value,
        email:document.getElementById("email").value,
        contactNumber:document.getElementById("contactNumber").value,
        enrollmentNumber:document.getElementById("enrollmentNumber").value,
        department:document.getElementById("department").value
    }
    console.log(Student);
    fetch(base_url+"/create",{
        method:"POST",
        headers:{
            "content-type":"application/json"
        },body:JSON.stringify(Student)
    }).then(response=>{
        if(!response.ok){
            alert("Failed to create Student with given data")
        }
        return response.json()
    }).then(()=>{
        window.location.href="../index.html"
    });
}

async function deleteStudent(number) {
    result = confirm(`This process will delete record with enrollment number : ${number} permanentely \n Do you wish to continue ?`);
    if(result){
        fetch(base_url+`/${number}`,{
            method:"DELETE",
            headers:{
                "content-type":"application/json"
            }
        }).then(response=>{
            if(!response.status(202)){
                alert(`Failed to delete ${number}`);
            }
        })
    }
}

async function loadStudent(enrollmentNumber) {
    window.location.href=`../html/updateStudent.html?enrollmentNumber=${enrollmentNumber}`
}

async function updateStudent() {
    const number = await document.getElementById("enrollmentNumber").value;

    result = confirm(`This process will update record with enrollment number : ${number} permanentely \n Do you wish to continue ?`);

    const Student = {
        name:document.getElementById("name").value,
        email:document.getElementById("email").value,
        contactNumber:document.getElementById("contactNumber").value,
        enrollmentNumber:number,
        department:document.getElementById("department").value
    }

    if(result){
        fetch(base_url+`/${number}`,{
            method:"PUT",
            headers:{
                    "content-type":"application/json"
            },body:JSON.stringify(Student)
        }).then(response=>{
            if(!response.ok){
                alert(`Failed to delete ${number}`);
            }
        }).then(()=>{
            window.location.href="./../index.html"
        })
    }
}
