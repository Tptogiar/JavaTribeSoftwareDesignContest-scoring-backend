
let websock = null
let messageCallback = null
let errorCallback = null
let wsUrl = ''

 
// 接收ws后端返回的数据
function websocketonmessage (e) { 
  messageCallback(e.data)
}
 
/**
 * 发起websocket连接
 * @param {Object} agentData 需要向后台传递的参数数据
 */
// function websocketSend (agentData) {
//   // 加延迟是为了尽量让ws连接状态变为OPEN   
//   setTimeout(() => { 
//     // 添加状态判断，当为OPEN时，发送消息
//     if (websock.readyState === websock.OPEN) { // websock.OPEN = 1 
//       // 发给后端的数据需要字符串化
//       websock.send(JSON.stringify(agentData))
//     }
//     if (websock.readyState === websock.CLOSED) { // websock.CLOSED = 3 
//       console.log('websock.readyState=3')
   
//       errorCallback()
//     }
//   }, 500)
// }
 
// 关闭ws连接
function websocketclose (e) {  
  // e.code === 1000  表示正常关闭。 无论为何目的而创建, 该链接都已成功完成任务。
  // e.code !== 1000  表示非正常关闭。
  if (e && e.code !== 1000) {
    
    errorCallback()
    // // 如果需要设置异常重连则可替换为下面的代码，自行进行测试
    // if (tryTime < 10) {
    //   setTimeout(function() {
    //    websock = null
    //    tryTime++
    //    initWebSocket()
    //    console.log(`第${tryTime}次重连`)
    //  }, 3 * 1000)
    //} else {
    //  Message.error('重连失败！请稍后重试')
    //}
  }
}
// 建立ws连接
function websocketOpen () {
  console.log('ws连接成功')
}
 
// 初始化weosocket
function initWebSocket (ip) { 
  if (typeof (WebSocket) === 'undefined') {

    return false
  }
  
 
  // ws请求完整地址
  const requstWsUrl = wsUrl + '/' + ip
  websock = new WebSocket(requstWsUrl)

  websock.onmessage = function (e) {
    websocketonmessage(e)
  } 
  websock.onopen = function () {
    websocketOpen()
  }
  websock.onerror = function (e) {
  
    errorCallback(e)
  }
  websock.onclose = function (e) {
    websocketclose(e)
  } 

  
}
 
/**
 * 发起websocket请求函数
 * @param {string} url ws连接地址
 * @param {string} token 连接token
 * @param {function} successCallback 接收到ws数据，对数据进行处理的回调函数
 * @param {function} errCallback ws连接错误的回调函数
 */
export function sendWebsocket (url, token, successCallback, errCallback) { 
  wsUrl = url
  initWebSocket(token)
  messageCallback = successCallback
  errorCallback = errCallback

}

/**
 * 关闭websocket函数
 */
export function closeWebsocket () {
  if (websock) {
    websock.close() // 关闭websocket
    websock.onclose() // 关闭websocket
  }
}




