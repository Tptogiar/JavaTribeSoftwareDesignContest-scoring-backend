# JavaTribeSoftwareDesignContest-scoring-backend





### 1、游客模块

~~~url
POST /result/getResult
~~~

~~~json
# 列表数组
[
    {
        "teamId": 0,                   #无用数据
        "teamName": "WanderFour",      #队伍ID
        "mark": 81.4286                #队伍总分
    },
    ...
    ,
    {
        "teamId": 0,
        "teamName": "Explosion",
        "mark": 64.5714
    }
]
~~~



### 2、评委模块

#### 1）登录

~~~url
POST /login/checkName
~~~

~~~json
// 返回数据
//验证成功
{
    "judge": {
        "id": 10,                        #评委ID，保存起来，免登录、评分都是要用到的
        "judgeName": "dyl",
        "judgePassword": "xxxx"
    },
    "message": "",
    "status": 200,                       #状态码
    "token": "f{nzzzzQampgQ{qwem5757755==7555"      #登录令牌，没有会被禁止登录
}

//验证失败
{
    "message": "用户名或密码错误！",
    "status": 1001
}

~~~

#### 2）退出登录

~~~url
POST /login/logout
~~~

~~~json
//附带参数  无
//返回结果
{
    "message": "登录痕迹已经清除！",
    "code": 200
}

//评分失败
{
    "message": "请重新尝试",
    "code": 5000
}
~~~

#### 3）获取未评分的队伍      

~~~url
POST /judge/getNoScoreTeam
~~~

~~~json
//附带参数
{
 	"id": 10                            #评委id
}
//返回参数
[
    {
        "id": 1,                          #队伍ID
        "teamName": "三个男人",            #队伍名
        "teamStatus": 1                   #上场状态  1表示下场，0表示上场
    },
    {
        "id": 3,
        "teamName": "WanderFour",
        "teamStatus": 1
    }
]
~~~

#### 4）获取已经评分的队伍

~~~url
POST /judge/getHasScoreTeam
~~~

~~~json
//附带参数
{ 
 	"id": 10                         #评委ID
}

//返回结果
[
    {
        "mark": 67,                  #该评委给出的分数
        "teamId": 1,                 #队伍ID
        "teamName": "行行行"          #队伍名
    },
    ......
    ,
    {
        "mark": 43,
        "teamId": 7,
        "teamName": "Explosion"
    }
]
~~~

#### 5）评分     

<font style="color:red; font-weight:bold;"> 从这里开始每次请求完之后拿到返回数据先判断一下 code的值，只有是200才表示本次操作成功了；如果是5000，表示操作失败了；如果是4000， 表示本次token已经失效了，将页面弹回去登录页面让评委重新登录一遍，拿到新的token</font>

~~~url
POST /judge/insertScore
~~~

~~~json
//附带参数
{
    "judgeId": 10,            #评委ID
    "teamId": 1,              #队伍ID
    "marks": 90               #分数
}
//返回结果                 
{
    "message": "评分成功！",
    "code": 200
}

//评分失败
{
    "message": "评分失败！请尝试刷新",
    "code": 5000
}
~~~

#### 5）修改评分

~~~url
POST /judge/updateScore
~~~



~~~json
//附带参数
{
    "judgeId": 10,                   #同评分
    "teamId": 1,
    "marks": 90
}
//返回结果
{
    "message": "修改成功！",
    "code": 200
}

//评分失败
{
    "message": "修改失败！请尝试刷新",
    "code": 5000
}
~~~


### 3、管理员模块

#### 1）管理队伍上场状态

~~~url
POST /judge/updateStatus
~~~

~~~json
//附带参数
{
	"id": 1,
    "teamStatus": 0/1            #上场的改成下场时传 1 过来， 上场就传0过来
}
//返回结果
{
    "message": "该队伍已改为上场状态！",
    "code": 200
}

//评分失败
{
    "message": "操作失败！请刷新重试",
    "code": 5000
}
~~~

#### 2）刷新缓存

~~~URL
GET /result/update              #用来刷新分数缓存的，能发请求过来就行
~~~

~~~json
//附带参数 无
//返回结果 不用处理
~~~

