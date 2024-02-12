import com.google.gson.annotations.SerializedName
import com.jggdevelopment.rangersstats.model.Name

data class Team(
    val id: Int,
    val placeName: Name,
    val abbrev: String,
    val logo: String
)
