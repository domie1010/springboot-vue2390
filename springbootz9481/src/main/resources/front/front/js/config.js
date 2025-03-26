
var projectName = '简历系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.html'
},

{
	name: '我的收藏',
	url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '简历模板',
	url: './pages/jianlimoban/list.html'
}, 
{
	name: '招聘会',
	url: './pages/zhaopinhui/list.html'
}, 
{
	name: '简历上传',
	url: './pages/jianlishangchuan/list.html'
}, 

{
	name: '求职论坛',
	url: './pages/forum/list.html'
}, 
{
	name: '系统公告',
	url: './pages/news/list.html'
},
]

var adminurl =  "http://localhost:8080/springbootz9481/admin/dist/index.html";

var cartFlag = false

var chatFlag = false


chatFlag = true


var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"简历模板","menuJump":"列表","tableName":"jianlimoban"}],"menu":"简历模板管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"模板类型","menuJump":"列表","tableName":"mobanleixing"}],"menu":"模板类型管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"招聘会","menuJump":"列表","tableName":"zhaopinhui"}],"menu":"招聘会管理"},{"child":[{"buttons":["审核","新增","查看","修改","删除"],"menu":"报名招聘","menuJump":"列表","tableName":"baomingzhaopin"}],"menu":"报名招聘管理"},{"child":[{"buttons":["审核","删除","修改","查看"],"menu":"简历上传","menuJump":"列表","tableName":"jianlishangchuan"}],"menu":"简历上传管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"求职论坛","tableName":"forum"}],"menu":"求职论坛"},{"child":[{"buttons":["修改","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"buttons":["新增","查看","修改","删除"],"menu":"系统公告","tableName":"news"},{"buttons":["新增","查看","修改","删除"],"menu":"在线客服","tableName":"chat"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"简历模板列表","menuJump":"列表","tableName":"jianlimoban"}],"menu":"简历模板模块"},{"child":[{"buttons":["查看","报名"],"menu":"招聘会列表","menuJump":"列表","tableName":"zhaopinhui"}],"menu":"招聘会模块"},{"child":[{"buttons":["查看","新增"],"menu":"简历上传列表","menuJump":"列表","tableName":"jianlishangchuan"}],"menu":"简历上传模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看"],"menu":"报名招聘","menuJump":"列表","tableName":"baomingzhaopin"}],"menu":"报名招聘管理"},{"child":[{"buttons":["查看","修改","删除","新增"],"menu":"简历上传","menuJump":"列表","tableName":"jianlishangchuan"}],"menu":"简历上传管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"简历模板列表","menuJump":"列表","tableName":"jianlimoban"}],"menu":"简历模板模块"},{"child":[{"buttons":["查看","报名"],"menu":"招聘会列表","menuJump":"列表","tableName":"zhaopinhui"}],"menu":"招聘会模块"},{"child":[{"buttons":["查看","新增"],"menu":"简历上传列表","menuJump":"列表","tableName":"jianlishangchuan"}],"menu":"简历上传模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
