package hello.typeconverter.formatter;

import static org.assertj.core.api.Assertions.*;

import java.text.ParseException;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class MyNumberFormatterTest {
  MyNumberFormatter formatter = new MyNumberFormatter();

  @Test
  void parse() throws ParseException {
    Number result = formatter.parse("1,0000", Locale.KOREA);
    assertThat(result).isEqualTo(10000L);
  }

  @Test
  void print(){
    String result = formatter.print(10000, Locale.KOREA);
    assertThat(result).isEqualTo("10,000");
  }

}