import ir.fastclick.core.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/movie/{id}")
    suspend fun getVASTUrl(@Path("id") id: String = "1"): ApiResponse
}
