package com.deloitte.deloittetask.base


interface BaseNavigator {
    fun showMessage(message: String)
    fun showMessage(messageRecource: Int)
    fun openNonUserPage()
    fun openUserPage()
    fun setLanguage(language:String)
    fun restartApp()
}