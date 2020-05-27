package hu.bme.mit.automatalearning.adapter

import java.io.File
import java.io.BufferedWriter
import java.io.FileWriter

class GammaProjectSerializer {
	CompositeMealyMachineSystemToGSCAdapter system;
	String path;
	
	//Path: "" - working dir, "/dir1/dir2.../" - full path
	new(CompositeMealyMachineSystemToGSCAdapter gammaSystem, String path) {
		this.system = gammaSystem
		this.path = path	
	}
	
	def void serialize() {
		createProjectDirectory
		serializeInterfaces
		serializeComponents
		serializeCompositeSystem
	}
	
	def void createProjectDirectory() {
		new File(path + system.systemName).mkdirs
	}
	
	def void serializeInterfaces() {
		var BufferedWriter bw = new BufferedWriter(new FileWriter(path + system.systemName + "/" + "Interfaces.gcd"))
		bw.write(system.getInterfaces)
		bw.close
	}
	
	def void serializeComponents() {
		for(compName : system.getComponents.keySet) {
			var BufferedWriter bw = new BufferedWriter(new FileWriter(path + system.systemName + "/" + compName + ".gcd"))
			bw.write(system.getComponents.get(compName))
			bw.close
		}
	}
	
	def void serializeCompositeSystem() {
		var BufferedWriter bw = new BufferedWriter(new FileWriter(path + system.systemName + "/" + system.systemName + ".gcd"))
		bw.write(system.getCompositeSystem)
		bw.close
	}
}