package hu.bme.mit.automatalearning;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import hu.bme.mit.lpt.LptPackage;

import hu.bme.mit.lpt.LPTRootNode;

public class LPTReader {
	public static LPTRootNode getLPT(String path) {
		LptPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
         m.put("lpt", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		 Resource resource = resSet.getResource(URI.createFileURI(path), true);
	        // Get the first model element and cast it to the right type, in my
	        // example everything is hierarchical included in this first node
		 LPTRootNode rootNode = (LPTRootNode) resource.getContents().get(0);
	        return rootNode;
	}

}
