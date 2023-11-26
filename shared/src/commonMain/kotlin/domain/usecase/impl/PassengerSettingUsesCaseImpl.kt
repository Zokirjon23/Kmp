package all.domain.usecase.impl

import all.domain.repository.PassengerSettingRepository
import all.domain.usecase.PassengerSettingUsesCase

class PassengerSettingUsesCaseImpl(private val settingRepository : PassengerSettingRepository) :
    PassengerSettingUsesCase {
}