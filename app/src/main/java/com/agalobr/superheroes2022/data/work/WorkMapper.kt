package com.agalobr.superheroes2022.data.work

import com.agalobr.superheroes2022.domain.Work

fun WorkApiModel.toDomain() = Work(this.occupation)