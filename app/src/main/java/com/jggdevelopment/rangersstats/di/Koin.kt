package com.jggdevelopment.rangersstats.di

import com.jggdevelopment.rangersstats.network.NhlApi
import com.jggdevelopment.rangersstats.repository.RangersRepository
import com.jggdevelopment.rangersstats.repository.RangersRepositoryImpl
import com.jggdevelopment.rangersstats.view_models.game_detail.GameDetailViewModel
import com.jggdevelopment.rangersstats.view_models.home.HomeViewModel
import com.jggdevelopment.rangersstats.view_models.player_detail.PlayerDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    factory {
        Retrofit.Builder().baseUrl("https://api-web.nhle.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
    factory<RangersRepository> { RangersRepositoryImpl(get()) }
    single<NhlApi> { provideNhlApi(get()) }

    viewModel { HomeViewModel(get()) }
    viewModel { (playerId: Int) ->
        PlayerDetailViewModel(
            get(),
            playerId
        )
    }
    viewModel { (gameId: Int) ->
        GameDetailViewModel(
            get(),
            gameId
        )
    }
}

fun provideNhlApi(retrofit: Retrofit): NhlApi =
    retrofit.create(NhlApi::class.java)
