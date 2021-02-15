`use strict`

const taskInput=document.getElementById("new-task");//Add a new task.
const addButton=document.getElementsByTagName("button")[0];//first button


const addTask = () => {
	
	fetch("http://localhost:8080/teacher/create", {
		method: "POST",
		headers: {'Access-Control-Allow-Origin': '*'},
		body: JSON.stringify({
			name: "Stacy",
			subject: 'Maths'
		})
	})
	.then(response => response.json())
	.then( res => console.log(res))
	
}


const editTask = () => {
	fetch("http://localhost:8080/teacher/update", {
		method: "PUT",
		headers: {'Access-Control-Allow-Origin': '*'},
		body: JSON.stringify({
			name: "Stacy",
			subject: 'Maths'
		})
	})
	.then(response => response.json())
	.then( res => console.log(res))
	
console.log("Edit Task...");
console.log("Change 'edit' to 'save'");

}


const deleteTask = () =>{
	fetch("http://localhost:8080/teacher/delete", {
		method: "DELETE",
		headers: {'Access-Control-Allow-Origin': '*'},
		body: JSON.stringify({
			name: "Stacy",
			subject: 'Maths'
		})
	})
	.then(response => response.json())
	.then( res => console.log(res))
	
		console.log("Delete Task...");


}





	