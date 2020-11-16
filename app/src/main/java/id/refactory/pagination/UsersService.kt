package id.refactory.pagination

import id.refactory.pagination.models.UsersResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface UsersService {
    @GET("users")
fun getAllUsers() : Call<UsersResponse>
}
