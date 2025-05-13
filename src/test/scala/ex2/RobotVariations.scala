package ex2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RobotWithBatteryTests extends AnyFlatSpec with Matchers:
  "A RobotWithBattery" should "turn correctly" in:
    val robot = new RobotWithBattery(SimpleRobot((0, 0), Direction.North), 50)

    robot.turn(Direction.East)
    robot.direction should be(Direction.East)

    robot.turn(Direction.South)
    robot.direction should be(Direction.South)

    robot.turn(Direction.West)
    robot.direction should be(Direction.West)

    robot.turn(Direction.North)
    robot.direction should be(Direction.North)

  it should "act correctly" in:
    val robot = new RobotWithBattery(SimpleRobot((0, 0), Direction.North), 50)

    robot.act()
    robot.position should be((0, 1))

    robot.turn(Direction.East)
    robot.act()
    robot.position should be((1, 1))

    robot.turn(Direction.South)
    robot.act()
    robot.position should be((1, 1))

    robot.turn(Direction.West)
    robot.act()
    robot.position should be((1, 1))

class RobotCanFailTests extends AnyFlatSpec with Matchers:
  "A RobotCanFail" should "turn correctly" in:
    val robot = new RobotCanFail(SimpleRobot((0, 0), Direction.North), 0.5)

    robot.turn(Direction.East)
    robot.direction should be(Direction.East)

    robot.turn(Direction.South)
    robot.direction should be(Direction.South)

    robot.turn(Direction.West)
    robot.direction should be(Direction.West)

    robot.turn(Direction.North)
    robot.direction should be(Direction.North)

  it should "act correctly" in:
    val robotWithoutFailures = new RobotCanFail(SimpleRobot((0, 0), Direction.North), 0)
    val robotAlwaysFailing = new RobotCanFail(SimpleRobot((0, 0), Direction.North), 1)

    robotWithoutFailures.act()
    robotWithoutFailures.position should be((0, 1))

    robotWithoutFailures.turn(Direction.East)
    robotWithoutFailures.act()
    robotWithoutFailures.position should be((1, 1))

    robotWithoutFailures.turn(Direction.South)
    robotWithoutFailures.act()
    robotWithoutFailures.position should be((1, 0))

    robotWithoutFailures.turn(Direction.West)
    robotWithoutFailures.act()
    robotWithoutFailures.position should be((0, 0))

    robotAlwaysFailing.act()
    robotAlwaysFailing.position should be((0, 0))

    robotAlwaysFailing.turn(Direction.East)
    robotAlwaysFailing.act()
    robotAlwaysFailing.position should be((0, 0))

    robotAlwaysFailing.turn(Direction.South)
    robotAlwaysFailing.act()
    robotAlwaysFailing.position should be((0, 0))

    robotAlwaysFailing.turn(Direction.West)
    robotAlwaysFailing.act()
    robotAlwaysFailing.position should be((0, 0))

class RobotRepeatedTests extends AnyFlatSpec with Matchers:
  "A RobotRepeated" should "turn correctly" in:
    val robot = new RobotRepeated(SimpleRobot((0, 0), Direction.North), 5)

    robot.turn(Direction.East)
    robot.direction should be(Direction.East)

    robot.turn(Direction.South)
    robot.direction should be(Direction.South)

    robot.turn(Direction.West)
    robot.direction should be(Direction.West)

    robot.turn(Direction.North)
    robot.direction should be(Direction.North)

  it should "act correctly" in:
    val robot = new RobotRepeated(SimpleRobot((0, 0), Direction.North), 5)

    robot.act()
    robot.position should be((0, 5))

    robot.turn(Direction.East)
    robot.act()
    robot.position should be((5, 5))

    robot.turn(Direction.South)
    robot.act()
    robot.position should be((5, 0))

    robot.turn(Direction.West)
    robot.act()
    robot.position should be((0, 0))
