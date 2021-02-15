`use strict`

//Solution: Add interactivity so the user can manage daily tasks.
//Break things down into smaller steps and take each step at a time.

//https://codepen.io/franklynroth/pen/ZYeaBd < REFERENCE ME

//Event handling, uder interaction is what starts the code execution.

const taskInput=document.getElementById("new-task");//Add a new task.
const addButton=document.getElementsByTagName("button")[0];//first button
const incompleteTaskHolder=document.getElementById("incomplete-tasks");//ul of #incomplete-tasks
const completedTasksHolder=document.getElementById("completed-tasks");//completed-tasks


const createNewTaskElement=function(taskString){

	let listItem=document.createElement("li");

	
	let checkBox=document.createElement("input");//checkbx
	let label=document.createElement("label");//label
	let editInput=document.createElement("input");//text
	let editButton=document.createElement("button");//edit button

	let deleteButton=document.createElement("button");//delete button

	label.innerText=taskString;

	checkBox.type="checkbox";
	editInput.type="text";

	editButton.innerText="Edit";
	editButton.className="edit";
	deleteButton.innerText="Delete";
	deleteButton.className="delete";



	listItem.appendChild(checkBox);
	listItem.appendChild(label);
	listItem.appendChild(editInput);
	listItem.appendChild(editButton);
	listItem.appendChild(deleteButton);
	return listItem;
}



const addTask=function(){
	console.log("Add Task...");
	let listItem=createNewTaskElement(taskInput.value);

	incompleteTaskHolder.appendChild(listItem);
	bindTaskEvents(listItem, taskCompleted);

	taskInput.value="";

}


const editTask=function(){
console.log("Edit Task...");
console.log("Change 'edit' to 'save'");


const listItem=this.parentNode;

let editInput=listItem.querySelector('input[type=text]');
let label=listItem.querySelector("label");
let containsClass=listItem.classList.contains("editMode");
		if(containsClass){

			label.innerText=editInput.value;
		}else{
			editInput.value=label.innerText;
		}

		listItem.classList.toggle("editMode");
}




const deleteTask=function(){
		console.log("Delete Task...");

		let listItem=this.parentNode;
		let ul=listItem.parentNode;
		ul.removeChild(listItem);

}


const taskCompleted=function(){
		console.log("Complete Task...");
	
	let listItem=this.parentNode;
	completedTasksHolder.appendChild(listItem);
				bindTaskEvents(listItem, taskIncomplete);

}


const taskIncomplete=function(){
		console.log("Incomplete Task...");
		let listItem=this.parentNode;
	incompleteTaskHolder.appendChild(listItem);
			bindTaskEvents(listItem,taskCompleted);
}



const ajaxRequest=function(){
	console.log("AJAX Request");
}



addButton.onclick=addTask;
addButton.addEventListener("click",addTask);
addButton.addEventListener("click",ajaxRequest);


const bindTaskEvents=function(taskListItem,checkBoxEventHandler){
	console.log("bind list item events");
	let checkBox=taskListItem.querySelector("input[type=checkbox]");
	let editButton=taskListItem.querySelector("button.edit");
	let deleteButton=taskListItem.querySelector("button.delete");


			editButton.onclick=editTask;
			deleteButton.onclick=deleteTask;
		
			checkBox.onchange=checkBoxEventHandler;
}


	for (let i=0; i<incompleteTaskHolder.children.length;i++){

		bindTaskEvents(incompleteTaskHolder.children[i],taskCompleted);
	}




	for (let i=0; i<completedTasksHolder.children.length;i++){
	
		bindTaskEvents(completedTasksHolder.children[i],taskIncomplete);
	}