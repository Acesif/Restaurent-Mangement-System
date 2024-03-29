import axios from 'axios'

const signupURI = "http://localhost:8081/api/v1/auth/signup"
export const signup = async (req) => {
   try{
      const result = await axios.post(signupURI,req);
      return {
         "data": result.data,
         "status": result.status,
         "header": result.headers
      }
   } catch (e){
      console.log(e)
   }
}