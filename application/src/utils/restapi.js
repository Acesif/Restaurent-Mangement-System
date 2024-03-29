import axios from 'axios'

const baseURI = "http://localhost:8080/api/v1/auth"
export const signup = async (req) => {
   try{
      const result = await axios.post(`${baseURI}/signup`,req);
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
      const result = await axios.post(`${baseURI}/login`,req);
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
