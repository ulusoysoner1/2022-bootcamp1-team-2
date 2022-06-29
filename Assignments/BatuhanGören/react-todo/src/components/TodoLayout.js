import React, { useState } from 'react'

function TodoLayout(props) {

    const [getInput, setInput] = useState('');
    
    const avoidRefresh = e =>{
        e.preventDefault();

        props.onSubmit({
          id: Math.floor(Math.random()*10000),
          text: getInput
        });

        setInput('');
    };

    const avoidChange = e =>{
        setInput(e.target.value);
    };
  return (

    <form className='todo-layout' onSubmit={avoidRefresh}>
        <input 
        className='todo-input'
        onChange={avoidChange}
        type="text"
        placeholder='Add something for todo'
        value={getInput}
        name='text'
        />
        <button className='todo-btn'>Add todo</button>
    </form>
  );
}

export default TodoLayout