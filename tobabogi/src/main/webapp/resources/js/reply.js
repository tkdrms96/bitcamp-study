const getReplyList = async (enbno_id,page) => {
    const response = await axios.get(`/replies/list/${enbno_id}?page=${page}`)

    return response.data

}




async function addReply(obj) { // 얘가 댓글 추가 기능

    const response = await axios.post("/replies", obj)

    return response.data

}




const removeReply = async(encno_id) => { // 특정 댓글 삭제니까 rno를r 파라미터로 받아야함.
    const response = await axios.put(`/replies/remove/${encno_id}`) // js 파일에서는 이렇게 backtick ` 이거 \ 백슬레시 없이 그냥 사용해도 된다.
    return response.data
}



const modifyReply = async (reply) => {

    const response = await axios.put(`/replies/${reply.encno_id}`, reply)

    return response.data

}

//밑에서부턴 답글영역

// async function modalLevelReply(LevelReplyObj){
//     const response = await axios.post("/replies/Level", LevelReplyObj)
//
//     return response.data
//
// } //답글 완성

const addLevelReply = async (LevelReplyObj) => {

    const response = await axios.post(`/replies/level`, LevelReplyObj)

    return response.data

}

