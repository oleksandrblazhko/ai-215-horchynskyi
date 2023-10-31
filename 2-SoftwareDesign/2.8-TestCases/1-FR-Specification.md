### Специфікація функції `setLightParams()`
**Вхідні параметри:**

1.1) `checkTime` - періодичність перевірки освітлення в хвилинах (integer):
- умова 1) – значення повинно бути додатнім цілим числом;
- умова 2) – значення не повинно перевищувати 99;
  
1.2) `minBrightness` - мінімальне значення яскравості світла (float):
- умова 3) – значення повинно бути у межах від 0.0 (мінімально можливе світло) до 1.0 (повна яскравість світла);
  
**Значення, що повертаються функцією:**
- значення = 1 – параметри успішно встановлені;
- значення = -1 – періодичність перевірки освітлення не відповідає умовам;
- значення = -2 – мінімальна яскравість не відповідає умовам.