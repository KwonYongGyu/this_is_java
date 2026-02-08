package com.mjc813.report.report01;//package com.mjc813.report.report01;
//
//import lombok.*;
//
//@Setter
//@NoArgsConstructor
////@AllArgsConstructor
public class Mjc813Calculator {
	public Long sum(Integer... arrs) throws NullPointerException {
		if (arrs == null) {
			throw new NullPointerException("arr is null");
		}
		Long result = 0L;
		for (Integer num : arrs) {
			result += num;
		}
		// arrs 값들의 모든 합을 구해야 합니다.
		// 다만 arrs 배열이 null 일 수 있으므로 예외처리를 이곳이든 이곳을 호출하는 메소드에서든 꼭 해야 합니다.
		return result;
	}

	public Long sum(Integer[] arrs, Integer start, Integer end) throws NullPointerException {
		Long result = 0L;
		// arrs 배열중에서 start ~ end 인덱스 까지의 원소들의 모든 합을 구해야 합니다.
		// 다만 arrs 배열이 null 일 수 도 있고, 원소가 null 일 수도 있고
		// 배열 인덱스 start ~ end 가 문제가 생길 수 도 있습니다.
		// 그러므로 예외처리를 꼭 해야 합니다.
		for ( int i = start; i <= end; i++ ) {
			result += arrs[i];
		}
		return result;
	}
////	public void CheckNullAndAddArrs(Integer inputNumber) throws Mjc813CalculatorNullException{
////		if( inputNumber == null){
////			throw new Mjc813CalculatorNullException("CheckNullAndAddArrs", "inputNumber is null");
////		}
////		}
//
//
}

