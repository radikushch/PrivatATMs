package com.test.privatatms

import java.lang.Exception

class ApiException(val errorCode: Int, val errorMessage: String) : Exception()

