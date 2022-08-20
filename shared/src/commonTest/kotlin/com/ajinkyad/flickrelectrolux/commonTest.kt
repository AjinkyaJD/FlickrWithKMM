package com.ajinkyad.flickrelectrolux

import com.ajinkyad.flickrelectrolux.data.remote.services.FlickrImageService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.koin.test.KoinTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class FlickrImagesTest : KoinTest {

    private lateinit var flickrImageService: FlickrImageService

    @Test
    fun response_Test_Default_Tag_Searched() = runTest {
        flickrImageService = HttpMockEngine().mockFlickerAPISuccessResponse()
        val response = flickrImageService.fetchPhotos(null)
        response?.process(
            failed = {

            },
            succeeded = {
                assertNotNull(it, "We have some response from endpoint with data")
            }
        )
    }

    @Test
    fun response_Test_Different_Tag_Searched() = runTest {
        flickrImageService = HttpMockEngine().mockFlickerAPISuccessResponseWithDifferentTag()
        val response = flickrImageService.fetchPhotos("Land")
        response?.process(
            failed = {

            },
            succeeded = {
                assertNotNull(it, "We have some response from endpoint with data")
            }
        )
    }

    @Test
    fun response_Test_Long_Random_Tag_Searched() = runTest {
        flickrImageService = HttpMockEngine().mockFlickerAPIEmptyResponse()
        val response = flickrImageService.fetchPhotos("RandomGibbreshTestTobeSearchedOnline")
        response?.process(
            failed = {

            },
            succeeded = {
                assertTrue(it!!.isEmpty())
            }
        )
    }
}