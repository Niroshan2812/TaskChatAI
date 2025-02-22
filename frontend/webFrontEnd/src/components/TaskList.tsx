import { useEffect, useState } from "react";
import { getTaskByUserId, deleteTask } from "../searvices/springapi";

interface Task{
    id:string;
    title:string;
    status:string;
}

const TaskList = () => {
const [tasks, setTasks] = useState<Task[]>([]);
const userId = "user124";
useEffect(() => {
    const fetchTasks = async () => {
        try {
            const data = await getTaskByUserId(userId);
            setTasks(data);
            
        } catch (error) {
            console.error("Error in fetch data", error);
            
        }
    };
    fetchTasks();
}, []);

const handleDelete = async (id: string) => {
    await deleteTask(id);
    setTasks(tasks.filter((task) => task.id !== id));
}


return(
    <div className="p-4">
    <h2 className="text-xl font-bold mb-4">Task List</h2>
    {tasks.length === 0 ? (
      <p>No tasks found.</p>
    ) : (
      <ul>
        {tasks.map((task) => (
          <li key={task.id} className="border p-2 mb-2">
            {task.title} - {task.status}
            <button onClick={() => handleDelete(task.id)} className="ml-2 text-red-500">
              ❌ Delete
            </button>
          </li>
        ))}
      </ul>
    )}
  </div>
)
}
export default TaskList;