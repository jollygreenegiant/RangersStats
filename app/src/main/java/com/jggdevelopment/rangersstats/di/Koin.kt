package com.jggdevelopment.rangersstats.di

import com.jggdevelopment.rangersstats.network.NhlApi
import com.jggdevelopment.rangersstats.repository.RangersRepository
import com.jggdevelopment.rangersstats.viewModels.home.HomeViewModel
import com.jggdevelopment.rangersstats.viewModels.player_detail.PlayerDetailViewModel
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
    factory { RangersRepository(get()) }
    single<NhlApi> { provideNhlApi(get()) }

    viewModel { HomeViewModel(get()) }
    viewModel { (playerId: Int) ->
        PlayerDetailViewModel(
            get(),
            playerId
        )
    }
}

fun provideNhlApi(retrofit: Retrofit): NhlApi =
    retrofit.create(NhlApi::class.java)
