package com.bit2b.gear.data.remote

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @POST("Anuncio/{offSet}")
    suspend fun createAnnouncement(@Path("offSet") offSet: Int)

    @GET("Anuncio/obtermeusanuncios/{idusuario}")
    suspend fun getUserAnnouncements(@Path("idusuario") idusuario: String)

    @GET("Anuncio/obteranuncio/{anuncioId}")
    suspend fun getAnnouncement(@Path("anuncioId") anuncioId: String)

    @POST("Anuncio")
    suspend fun createAnnouncements()

    @PUT("Anuncio")
    suspend fun updateAnnouncement()






}