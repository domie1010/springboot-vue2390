const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootz9481/",
            name: "springbootz9481",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootz9481/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "简历系统"
        } 
    }
}
export default base
