export const saveSession = (res) => {

    const token = localStorage.getItem('access-token')
    if(token === null){
        localStorage.setItem('access-token',res.data.jwt)
        localStorage.setItem("user",JSON.stringify({
            "id": res.data.id,
            "role": res.data.role,
            "name": res.data.name
        }))
    }
}
export const getSession = () => {
    const token = localStorage.getItem("user")
    if(token !== null){
        return JSON.parse(token)
    }
    return null
}
export const endSession = () => {
    localStorage.clear()
}
