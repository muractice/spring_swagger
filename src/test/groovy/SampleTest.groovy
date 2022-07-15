import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SampleTest extends Specification{
    def "Should be a simple assersion"() {
        expect:
        1 == 1
    }
}
