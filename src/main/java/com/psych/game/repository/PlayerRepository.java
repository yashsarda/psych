/**
 *  Need for this class
 *  The Player class identifies one particular row of the Players table. But how do we identify the complete table
 *  For eg: if we want to know the number of rows in the table, the Player class will not be able to answer this
 *  This class is helpful for all these. It actually identifies the complete table
 */

package com.psych.game.repository;

import com.psych.game.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @arg1 : The type of the object in each row of the table
 * @arg2 : The type of unique identifier
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
