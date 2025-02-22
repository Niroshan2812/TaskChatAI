import axios from "axios";

const API_URL = "http://localhost:8080/api/tasks";

export const getTaskByUserId = async (userId: string) => {
    const response = await axios.get(`${API_URL}/${userId}`);
    return response.data;
}
export const createTask = async (task: { title: string; status: string; userId: string }) => {
    const response = await axios.post(API_URL, task);
    return response.data;
  };
  
  export const updateTask = async (id: string, updatedTask: { title?: string; status?: string }) => {
    const response = await axios.put(`${API_URL}/${id}`, updatedTask);
    return response.data;
  };
  
  export const deleteTask = async (id: string) => {
    await axios.delete(`${API_URL}/${id}`);
  };