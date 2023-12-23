package com.example.ko

import android.R
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        getFirebaseMessage(
            remoteMessage.notification?.title, remoteMessage.notification?.body
        )
    }

    fun getFirebaseMessage(title: String?, msg: String?) {
        val builder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, "myFirebaseChannel")
                .setSmallIcon(R.drawable.sym_def_app_icon)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true)
        val manager = NotificationManagerCompat.from(this)
        manager.notify(101, builder.build())
    }


}