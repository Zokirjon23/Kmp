package all.domain.usecase.impl

import all.domain.repository.PassengerMapRepository
import all.domain.usecase.PassengerMapUsesCase

class PassengerMapUsesCaseImpl(private val mapRepository : PassengerMapRepository) :
    PassengerMapUsesCase {
}