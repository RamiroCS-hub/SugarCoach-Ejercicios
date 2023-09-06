package com.example.pokemonhoroscope.main.imageManage

class ImageRepository(private val api: ImageApi) {

    suspend fun getImage(id: Int): String{
        try {
            val response = api.getImage(id)
            return formatUrl(response)
        }catch (e: Exception){
            return ""
        }
    }
    private fun formatUrl(response: ImageResponse): String{
        return response.sprites.front_default
    }
}