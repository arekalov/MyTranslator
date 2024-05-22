package com.arekalov.mytranslator.di

import com.arekalov.data.di.DataComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [DataComponent::class])
class AppModule