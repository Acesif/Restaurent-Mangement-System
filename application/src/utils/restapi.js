import axios from 'axios'

const baseURI = "http://localhost:8080/api/v1"
const token = localStorage.getItem('access-token');
export const signup = async (req) => {
   try{
      const result = await axios.post(`${baseURI}/auth/signup`,req);
      return {
         "data": result.data,
         "status": result.status,
         "header": result.headers
      }
   } catch (e){
      console.log(e)
      return e
   }
}
export const login = async (req) => {
   try{
      const result = await axios.post(`${baseURI}/auth/login`,req);
      return {
         "data": result.data,
         "status": result.status,
         "header": result.headers
      }
   } catch (e){
      console.log(e)
      return e
   }
}

export const upload = async (formData) => {
   const headers = {
      "Authorization": `Bearer ${token}`,
      "Content-Type" : "multipart/form-data", // Update Content-Type to multipart/form-data
   };

   try {
      const result = await axios.post(`${baseURI}/admin/category`, formData, { headers });
      return {
         "data": result.data,
         "status": result.status,
         "header": result.headers
      };
   } catch (e) {
      console.log(e);
      return e;
   }
};
export const getCategories = async() => {
   try{
      const result = await axios.get(`${baseURI}/admin/category`);
      return {
         "data": result.data,
         "status": result.status,
         "header": result.headers
      };
   } catch (e){
      console.log(e)
      return e
   }
}

