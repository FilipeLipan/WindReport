package com.example.fejn.windreport.data.repository.exception

import com.example.fejn.windreport.data.repository.exception.KnownError

open class KnownException(var knownError: KnownError = KnownError.UNKNOWN_EXCEPTION, message:String) : Exception( message)
