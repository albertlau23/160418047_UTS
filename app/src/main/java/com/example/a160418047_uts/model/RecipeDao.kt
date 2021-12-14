package com.example.a160418047_uts.model

import androidx.room.*


@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipe: Recipe)

    @Query("SELECT * FROM Recipe")
    suspend fun selectAllRecipe(): List<Recipe>

    @Query("SELECT * FROM Recipe WHERE id= :id")
    suspend fun selectRecipe(id: Int): Recipe
    @Query("select r.* from Recipe r inner join User u on u.uuid=r.uid where u.username=:id")
    suspend fun selectMyRecipe(id: String):List<Recipe>
    @Delete
    suspend fun deleteRecipe(recipe: Recipe)
}
@Dao
interface UserDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user: User)

    @Query("SELECT * FROM User")
    suspend fun selectAllUser(): List<User>

    @Query("SELECT * FROM User WHERE username= :id and password=:pass")
    suspend fun selectUser(id: String,pass:String): User
    @Query("SELECT * FROM User WHERE username= :id")
    suspend fun viewUser(id: String): User


}

