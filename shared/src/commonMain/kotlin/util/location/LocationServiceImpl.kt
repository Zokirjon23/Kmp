package util.location


import util.location.LocationService

class LocationServiceImpl(
//    private val context: Context,
//    private val locationClient: FusedLocationProviderClient
): LocationService {
    //    override fun requestLocationUpdates(): Flow<LatLng?> = callbackFlow {
//
//        if (!context.hasLocationPermission()) {
//            trySend(null)
//            return@callbackFlow
//        }
//
//        val request = LocationRequest.Builder(10000L)
//            .setIntervalMillis(10000L)
//            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
//            .build()
//
//        val locationCallback = object : LocationCallback() {
//            override fun onLocationResult(locationResult: LocationResult) {
//                locationResult.locations.lastOrNull()?.let {
//                    trySend(LatLng(it.latitude, it.longitude))
//                }
//            }
//        }
//
//        locationClient.requestLocationUpdates(
//            request,
//            locationCallback,
//            Looper.getMainLooper()
//        )
//
//        awaitClose {
//            locationClient.removeLocationUpdates(locationCallback)
//        }
//    }
//

    override fun requestLocationUpdates(): Any {
        return 0
    }
}