import numpy as np

class Nash:
    def solving_matrix(self, a_strategy, b_strategy):
        i, j, count = 0, 0, 0

        equilibrium_strategies = [np.zeros((3, 3)), np.zeros((3, 3))]
        has_played_strategy_A = np.zeros((3, 3), dtype=bool)
        has_played_strategy_B = np.zeros((3, 3), dtype=bool)
        a_nash = np.zeros((3, 3))
        b_nash = np.zeros((3, 3))

        while count <= 100:
            if count % 2 == 0:
                loss = min(a_strategy[i][j] + b_strategy[(i + 1) % 3][0],
                           a_strategy[i][j] + b_strategy[(i + 1) % 3][1])

                if has_played_strategy_A[(i + 1) % 3][0]:
                    loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][1]
                elif has_played_strategy_A[(i + 1) % 3][1]:
                    loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][0]

                loss = min(loss, a_strategy[i][j] + b_strategy[(i + 1) % 3][2])

                if has_played_strategy_A[(i + 1) % 3][2] and (loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][2]):
                    loss = min(a_strategy[i][j] + b_strategy[(i + 1) % 3][0],
                               a_strategy[i][0] + b_strategy[(i + 1) % 3][1])

                    if has_played_strategy_A[(i + 1) % 3][0]:
                        loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][1]
                    elif has_played_strategy_A[(i + 1) % 3][1]:
                        loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][0]

                elif has_played_strategy_A[(i + 1) % 3][1] and has_played_strategy_A[(i + 1) % 3][0]:
                    loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][2]

                if loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][0]:
                    has_played_strategy_A[(i + 1) % 3][0] = True
                    b_nash[(i + 1) % 3][0] += 1
                    j = 0
                    if count == 17:
                        j = 0
                elif loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][1]:
                    has_played_strategy_A[(i + 1) % 3][1] = True
                    b_nash[(i + 1) % 3][1] += 1
                    j = 1
                    if count == 17:
                        j = 1
                else:
                    has_played_strategy_A[(i + 1) % 3][2] = True
                    b_nash[(i + 1) % 3][2] += 1
                    j = 2
                    if count == 17:
                        j = 2
                i = (i + 1) % 3
                count += 1
            else:
                loss = min(b_strategy[i][j] + a_strategy[(i + 1) % 3][0],
                           b_strategy[i][j] + a_strategy[(i + 1) % 3][1])

                if has_played_strategy_B[(i + 1) % 3][0]:
                    loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][1]
                elif has_played_strategy_B[(i + 1) % 3][1]:
                    loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][0]

                loss = min(loss, b_strategy[i][j] + a_strategy[(i + 1) % 3][2])

                if has_played_strategy_B[(i + 1) % 3][2] and (loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][2]):
                    loss = min(b_strategy[i][j] + a_strategy[(i + 1) % 3][0],
                               b_strategy[i][0] + a_strategy[(i + 1) % 3][1])

                    if has_played_strategy_B[(i + 1) % 3][0]:
                        loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][1]
                    elif has_played_strategy_B[(i + 1) % 3][1]:
                        loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][0]

                elif has_played_strategy_B[(i + 1) % 3][1] and has_played_strategy_B[(i + 1) % 3][0]:
                    loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][2]

                if loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][0]:
                    has_played_strategy_B[(i + 1) % 3][0] = True
                    a_nash[(i + 1) % 3][0] += 1
                    j = 0
                    if count == 17:
                        j = 0
                elif loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][1]:
                    has_played_strategy_B[(i + 1) % 3][1] = True
                    a_nash[(i + 1) % 3][1] += 1
                    j = 1
                    if count == 17:
                        j = 1
                else:
                    has_played_strategy_B[(i + 1) % 3][2] = True
                    a_nash[(i + 1) % 3][2] += 1
                    j = 2
                    if count == 17:
                        j = 2
                i = (i + 1) % 3
                count += 1
        count = 0
        while count <= 1000:
            if count % 2 == 0:
                loss = min(a_strategy[i][j] + b_strategy[(i + 1) % 3][0],
                           a_strategy[i][0] + b_strategy[(i + 1) % 3][1])

                loss = min(loss, a_strategy[i][j] + b_strategy[(i + 1) % 3][2])

                if loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][0]:
                    if abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][0]) == abs(
                            a_strategy[i][j] + b_strategy[(i + 1) % 3][1]):
                        b_nash[(i + 1) % 3][0] += 1
                        b_nash[(i + 1) % 3][1] += 1
                    elif abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][0]) == abs(
                            a_strategy[i][j] + b_strategy[(i + 1) % 3][2]):
                        b_nash[(i + 1) % 3][0] += 1
                        b_nash[(i + 1) % 3][2] += 1
                    else:
                        b_nash[(i + 1) % 3][0] += 1
                    j = 0
                elif loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][1]:
                    if abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][1]) == abs(
                            a_strategy[i][j] + b_strategy[(i + 1) % 3][0]):
                        b_nash[(i + 1) % 3][1] += 1
                        b_nash[(i + 1) % 3][0] += 1
                    elif abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][1]) == abs(
                            a_strategy[i][j] + b_strategy[(i + 1) % 3][2]):
                        b_nash[(i + 1) % 3][1] += 1
                        b_nash[(i + 1) % 3][2] += 1
                    else:
                        b_nash[(i + 1) % 3][1] += 1
                    j = 1
                else:
                    if abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][2]) == abs(
                            a_strategy[i][j] + b_strategy[(i + 1) % 3][0]):
                        b_nash[(i + 1) % 3][2] += 1
                        b_nash[(i + 1) % 3][0] += 1
                    elif abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][2]) == abs(
                            a_strategy[i][j] + b_strategy[(i + 1) % 3][1]):
                        b_nash[(i + 1) % 3][2] += 1
                        b_nash[(i + 1) % 3][1] += 1
                    else:
                        b_nash[(i + 1) % 3][2] += 1
                    j = 2
                i = (i + 1) % 3
                count += 1
            else:
                loss = min(b_strategy[i][j] + a_strategy[(i + 1) % 3][0],
                           b_strategy[i][0] + a_strategy[(i + 1) % 3][1])

                loss = min(loss, b_strategy[i][j] + a_strategy[(i + 1) % 3][2])

                if loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][0]:
                    if abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][0]) == abs(
                            b_strategy[i][j] + a_strategy[(i + 1) % 3][1]):
                        a_nash[(i + 1) % 3][0] += 1
                        a_nash[(i + 1) % 3][1] += 1
                    elif abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][0]) == abs(
                            b_strategy[i][j] + a_strategy[(i + 1) % 3][2]):
                        a_nash[(i + 1) % 3][0] += 1
                        a_nash[(i + 1) % 3][2] += 1
                    else:
                        a_nash[(i + 1) % 3][0] += 1
                    j = 0
                elif loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][1]:
                    if abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][1]) == abs(
                            b_strategy[i][j] + a_strategy[(i + 1) % 3][0]):
                        a_nash[(i + 1) % 3][1] += 1
                        a_nash[(i + 1) % 3][0] += 1
                    elif abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][1]) == abs(
                            b_strategy[i][j] + a_strategy[(i + 1) % 3][2]):
                        a_nash[(i + 1) % 3][1] += 1
                        a_nash[(i + 1) % 3][2] += 1
                    else:
                        a_nash[(i + 1) % 3][1] += 1
                    j = 1
                else:
                    if abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][2]) == abs(
                            b_strategy[i][j] + a_strategy[(i + 1) % 3][0]):
                        a_nash[(i + 1) % 3][2] += 1
                        a_nash[(i + 1) % 3][0] += 1
                    elif abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][2]) == abs(
                            b_strategy[i][j] + a_strategy[(i + 1) % 3][1]):
                        a_nash[(i + 1) % 3][2] += 1
                        a_nash[(i + 1) % 3][1] += 1
                    else:
                        a_nash[(i + 1) % 3][2] += 1
                    j = 2
                i = (i + 1) % 3
                count += 1

        probability_distribution_A = a_nash / a_nash.sum(axis=1, keepdims=True)
        probability_distribution_B = b_nash / b_nash.sum(axis=1, keepdims=True)

        equilibrium_strategies[0] = probability_distribution_A
        equilibrium_strategies[1] = probability_distribution_B

        return equilibrium_strategies[0],equilibrium_strategies[1]

