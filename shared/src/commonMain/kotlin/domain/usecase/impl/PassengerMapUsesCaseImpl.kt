package domain.usecase.impl

import domain.repository.PassengerMapRepository
import domain.usecase.PassengerMapUsesCase

class PassengerMapUsesCaseImpl(private val mapRepository : PassengerMapRepository) :
    PassengerMapUsesCase {
}