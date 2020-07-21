import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

def a = 'welcome'

def b = 'test'

def c = 'welcome'

def assertFailedSummary = []

//Call the maxval assert Keyword - verifyEqual - object
def assertResult = CustomKeywords.'com.maxval.plugin.keyword.asserts.GroovyAsserts.verifyEqual'(a, b)

//Collect the assertion Failed summary
def summary = CustomKeywords.'com.maxval.plugin.keyword.asserts.GroovyAsserts.assertSummaryCollection'(assertResult)

//If its Failed added into the list.
if (summary != null) {
    assertFailedSummary.add(summary)
}

//Call the maxval assert Keyword - verifyEqual -value
assertResult = CustomKeywords.'com.maxval.plugin.keyword.asserts.GroovyAsserts.verifyValueEqual'(c, 'welcome123')

//Collect the assertion Failed summary
summary = CustomKeywords.'com.maxval.plugin.keyword.asserts.GroovyAsserts.assertSummaryCollection'(assertResult)

if (summary != null) {
    assertFailedSummary.add(summary)
}

//Call the maxval assert Keyword - verifyEqual -value
def assertResult1 = CustomKeywords.'com.maxval.plugin.keyword.asserts.GroovyAsserts.verifyEqual'(a, c)

//Collect the assertion Failed summary
summary = CustomKeywords.'com.maxval.plugin.keyword.asserts.GroovyAsserts.assertSummaryCollection'(assertResult1)

if (summary != null) {
    assertFailedSummary.add(summary)
}

//IF Any asserts Failed, marked test case as failed , Else test case passed
if (assertFailedSummary) {
    KeywordUtil.markFailed(assertFailedSummary.toString())
}