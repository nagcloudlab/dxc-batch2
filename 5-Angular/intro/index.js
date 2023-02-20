

//-----------------------------------------------
// using DOM API
//-----------------------------------------------


const box = document.querySelector('.alert');
const greetBtn = document.querySelector('.btn-success');
const hideBtn = document.querySelector('.btn-danger');
const showBtn = document.querySelector('.btn-primary');

greetBtn.addEventListener('click', () => {
    box.innerText = "hello DXC"
})
hideBtn.addEventListener('click', () => {
    box.style.display = 'none';
})
showBtn.addEventListener('click', () => {
    box.style.display = 'block';
})



//-----------------------------------------------
// using DOM API + Timer Api
//-----------------------------------------------

const timeNow = document.getElementById("time-now") // search
setInterval(() => {
    timeNow.innerText = new Date().toLocaleTimeString('en-US', { timeZone: "Asia/Kolkata" })
}, 1000);



//-----------------------------------------------
// using DOM API + XHR/Fetch Api
//-----------------------------------------------

const apiUrl = "https://jsonplaceholder.typicode.com/todos?_limit=5"
const top5TodosBtn = document.getElementById("top5-todos-btn")
const todosTableBody = document.getElementById("todos-table-body");

top5TodosBtn.addEventListener("click", () => {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            data.forEach(todo => {
                todosTableBody.innerHTML += `
                <tr class="${todo.completed ? 'bg-success' : ''}">
                    <td>${todo.id}</td>
                    <td>${todo.title}</td>
                    <td>${todo.completed}</td>
                </tr>
                `
            })
        });
});