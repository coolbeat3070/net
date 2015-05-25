package apix.swing;

public class Lotto {
	int[] lotto = new int[6];

	public int[] getLotto() {
		return lotto;
	}

	public void setLotto() {
		for (int i = 0; i < lotto.length; i++) { 
			lotto[i] = 0;
		}
		

		// 로또 당첨번호 저장
		for (int i = 0; i < lotto.length; i++) {

			// 1~45 까지의 번호 중 임의의 수 생성
			int randomNum = (int) (Math.random() * 45 + 1);
			// 이미 등록된 번호인지의 여부
			boolean exist = false;

			// 등록된 번호 확인
			for (int j = 0; j < lotto.length; j++) {
				// 임의의 수가 이미 등록된 번호인지 확인한다.
				if (randomNum == lotto[j]) {
					exist = true;
					break; // 등록된 번호이면 번호확인 종료
				}
			}

			if (exist) {
				// 등록된 번호이면 다시 등록
				i--;
				continue;
			} else {
				// 등록된 번호가 아니면 임의의 수 등록
				lotto[i] = randomNum;
				
			}

		}
		sort(lotto);
	}
	public void sort(int[] array) {
		  for (int i = 0; i < array.length - 1; i++) {
		   for (int j = 0; j < array.length - i - 1; j++) {
		    if (array[j] > array[j + 1]) {
		     int temp;
		     temp = array[j];
		     array[j] = array[j + 1];
		     array[j + 1] = temp;
		    }
		   }
		  }
		 }
}
