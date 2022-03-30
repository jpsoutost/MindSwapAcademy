package academy.mindswap.wtfjunit;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Calculator {

    private OtherClass otherClass;

    public Calculator(OtherClass otherClass) {
        this.otherClass = otherClass;
    }

    public int sumTwoNumbers(Integer n1, Integer n2){

        if(Objects.isNull(n1) || Objects.isNull(n2)) {
            throw new InvalidParameterException();
        }

        return n1+n2;
    }

    public String getNewReference(int length){
        StringBuilder reference = new StringBuilder();

        for (Integer n: otherClass.getRandomNumbers(length)) {
            reference.append(n);
        }

        otherClass.printReference(reference.toString());

        return reference.toString();
    }
}
