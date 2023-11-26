package domain.usecase.impl

import domain.repository.PassengerSettingRepository
import domain.usecase.PassengerSettingUsesCase

class PassengerSettingUsesCaseImpl(private val settingRepository : PassengerSettingRepository) :
    PassengerSettingUsesCase {
}