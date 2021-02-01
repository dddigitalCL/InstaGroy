package com.example.instagroy.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class User(
    val id: Int =-1,
    val name: String = "",
    val user: String = "",
    val password: String = "",
    val email: String= "",
    val description:String = "",
    val photo:String= ""
)


data class UserList(
        var mutableUser: MutableList<User> = mutableListOf(
                User(101,"Jose","Userjose","Passwordjose","jose@gmail.com","mi nombre es jose","https://storage-dating.euranka.com/uploads/sites/20/2018/06/apps-para-ligar-fotos-de-perfil-atraer-chicas.png"),
                User(102,"Franco","Userfranco","Passwordfranco","franco@gmail.com","mi nombre es franco","https://www.lavanguardia.com/r/GODO/LV/p5/WebSite/2018/07/25/Recortada/img_econcejo_20180730-165058_imagenes_lv_terceros_istock-894361286-k0hH--656x438@LaVanguardia-Web.jpg"),
                User(103,"Denis","Userdenis","Passworddenis","denis@gmail.com","mi nombre es denis","https://socialtools.me/wp-content/uploads/2016/04/foto-de-perfil.jpg")
        )
)


@Entity
data class UserEntity(
        @PrimaryKey
        val id: Int =-1,
        @ColumnInfo(name ="name")
        val name: String = "",
        @ColumnInfo(name ="user")
        val user: String = "",
        @ColumnInfo(name ="password")
        val password: String = "",
        @ColumnInfo(name ="email")
        val email: String= "",
        @ColumnInfo(name ="description")
        val description:String = "",
        @ColumnInfo(name ="photo")
        val photo:String= ""
)

fun List<UserEntity>.toUserList(): UserList{
        val resultMutableUser = mutableListOf<User>()
        this.forEach{ userEntity ->
                resultMutableUser.add(userEntity.toUser())
        }
        return UserList(resultMutableUser)
}

fun UserEntity.toUser(): User = User( this.id, this.name, this.user, this.password, this.email, this.description, this.photo)

fun User.toUserEntity(): UserEntity = UserEntity(this.id, this.name, this.user, this.password, this.email, this.description, this.photo)