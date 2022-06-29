import React, { useState } from 'react';
import Todo from './Todo';
import TodoLayout from './TodoLayout';

function TodoList() {

    const [todos, setTodos] = useState([]);

    const addTodo = todo => {
        if(!todo.text || /^\s*$/.test(todo.text)){
            return;
        }
        const newTodos = [todo,...todos];

        setTodos(newTodos);
        console.log(...todos);
    };

    const completeTodo = id=> {
    let updatedTodos = todos.map(todo => {
        if(todo.id === id){
            todo.isComplete = !todo.isComplete; 
        }
        return todo;
    });
        setTodos(updatedTodos);
    };

    const removeTodo =id => {
        const removeArr= [...todos].filter(todo => todo.id !== id)
        setTodos(removeArr);
    }

  return (
    <div>
        <h1>Remember what todo</h1>
        <TodoLayout onSubmit={addTodo} />
        <Todo todos={todos} completeTodo={completeTodo} removeTodo={removeTodo}/>
    </div>
  );
}

export default TodoList;