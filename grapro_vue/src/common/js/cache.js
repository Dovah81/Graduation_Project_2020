import storage from 'good-storage'

//定义存取用户信息的KEY
const USER_KEY = '__user'

/**
 * 存储用户信息
 * @param obj
 */
export function saveUser(obj){
    storage.set(USER_KEY,obj)
}

/**
 * 取用户信息
 */
export function getUser(){
    return storage.get(USER_KEY,{})
}

/**
 * 清除用户信息
 */
export function clearUser(){
    storage.set(USER_KEY,{})
}