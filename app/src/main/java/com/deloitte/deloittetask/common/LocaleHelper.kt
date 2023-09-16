package com.deloitte.deloittetask.common

import android.content.Context
import android.os.Build
import android.view.View
import android.view.Window
import androidx.preference.PreferenceManager
import java.util.*

object LocaleHelper {
    val SELECTED_LANGUAGE = "en"
    fun setLocale(window: Window, language: String): Context {
        persist(window.context, language)
        changeDirectionLanguage(window, language)

        // updating the language for devices above android nougat
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResources(window.context, language);
        }
        // for devices having lower version of android os
        return updateResourcesLegacy(window.context, language);
    }

    fun persist(context: Context, language: String) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }


    // the method is used to update the language of application by creating
    // object of inbuilt Locale class and passing language argument to it
    fun updateResources(context: Context, language: String): Context {
        val newLocale = Locale(language)
        Locale.setDefault(newLocale)
        val configuration = context.resources.configuration
        configuration.setLocale(newLocale)
        configuration.setLayoutDirection(newLocale)

        return context.createConfigurationContext(configuration)
    }

    fun updateResourcesLegacy(context: Context, language: String): Context {
        val newLocale = Locale(language)
        Locale.setDefault(newLocale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.setLocale(newLocale)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(newLocale);
        }
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }

    private fun changeDirectionLanguage(window: Window, language: String) {
        if (language.equals("ar", ignoreCase = true)) {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
            window.decorView.textDirection = View.TEXT_DIRECTION_ANY_RTL
        } else {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
            window.decorView.textDirection = View.TEXT_DIRECTION_LTR
        }
    }
}