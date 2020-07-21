package com.maxval.plugin.keyword.asserts

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class GroovyAsserts {
	def assertMessage =[:]

	@Keyword
	def verifyEqual(actualObject,expectedObject){
		try{
			//assert WebUI.verifyEqual(actualObject, expectedObject)
			assert actualObject==expectedObject
			def successMessage = "actual Object :" +actualObject +"And Expected Object :" +expectedObject +"are equal"

		}catch(AssertionError assertionError){
			assertMessage.put("fail",assertionError.getMessage())
		}
		return assertMessage
	}

	@Keyword
	def verifyValueEqual(object, value){
		try{
			assert object==value
		}catch(AssertionError assertionError){
			assertMessage.put("fail",assertionError.getMessage())
		}
		return assertMessage
	}

	@Keyword
	def booleanTrue(){
	}

	@Keyword
	def assertSummaryCollection(assertResult){
		def assertMessage
		def assertError = assertResult.find({ it.key == 'fail' })

		if (assertError) {
			assertMessage="$assertError"
		} else {
		}
		//return [assertfailMessage, assertPassedMessage]
		return assertMessage
	}
}
